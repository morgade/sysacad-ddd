
DROP TABLE app.Inscricao;
DROP TABLE app.Turma;
DROP TABLE app.Curso_Disciplina;
DROP TABLE app.Aluno;
DROP TABLE app.Curso;
DROP TABLE app.Telefone;
DROP TABLE app.Disciplina;
DROP TABLE app.Professor;



CREATE TABLE app.Aluno
(
	alun_cd_aluno     INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY,
	alun_nm_aluno     VARCHAR(100) NOT NULL,
	alun_cd_cpf       VARCHAR(14) NOT NULL,
	alun_nr_telefone  VARCHAR(15),
	alun_tx_endereco  VARCHAR(255) NOT NULL,
	alun_nr_cep       VARCHAR(9) NOT NULL,
	alun_IN_SEXO       CHAR(1) NOT NULL,
	alun_dt_nascimento DATE NOT NULL,
	curs_cd_curso     INTEGER
)
;


CREATE TABLE app.Curso
(
	curs_cd_curso      INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY,
	curs_nm_curso      VARCHAR(100) NOT NULL,
	curs_tx_descricao  VARCHAR(255) NOT NULL
)
;


CREATE TABLE app.Curso_Disciplina
(
	disc_cd_disciplina  CHAR(4)  NOT NULL,
	curs_cd_curso       INTEGER  NOT NULL
)
;


CREATE TABLE app.Disciplina
(
	disc_cd_disciplina    CHAR(4)  NOT NULL,
	disc_nm_disciplina    VARCHAR(100) NOT NULL,
	disc_nt_carg_horario  NUMERIC(5) NOT NULL,
	disc_tx_disciplina    VARCHAR(255)
)
;


CREATE TABLE app.Inscricao
(
	insc_cd_inscricao  INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY,
	insc_dt_inscricao  TIMESTAMP NOT NULL,
	insc_in_status     VARCHAR(20) NOT NULL default 'PENDENTE',
	alun_cd_aluno      INTEGER  NOT NULL,
	turm_cd_turma      INTEGER  NOT NULL
)
;


CREATE TABLE app.Professor
(
	prof_cd_professor  INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY,
	prof_cd_cpf        VARCHAR(14) NOT NULL,
	prof_nm_professor  VARCHAR(100) NOT NULL
)
;


CREATE TABLE app.Telefone
(
	tele_cd_telefone       INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY,
	tele_nr_telefone       VARCHAR(15) NOT NULL,
	tele_in_tipo_telefone  CHAR(1) NOT NULL,
	prof_cd_professor      INTEGER  NOT NULL
)
;


CREATE TABLE app.Turma
(
	turm_cd_turma           INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY,
	turm_nr_vagas           NUMERIC(5) NOT NULL,
	turm_nr_sala            NUMERIC(5) NOT NULL,
	turm_in_turno           INTEGER NOT NULL,
	turm_dt_periodo_inicio  DATE NOT NULL,
	turm_dt_periodo_fim     DATE NOT NULL,
	turm_tx_comentario      CLOB,
	disc_cd_disciplina      CHAR(4)  NOT NULL,
	prof_cd_professor       INTEGER  NOT NULL
)
;



ALTER TABLE app.Aluno ADD CONSTRAINT PK_ALUN 
	PRIMARY KEY (alun_cd_aluno)
;

ALTER TABLE app.Curso ADD CONSTRAINT PK_CURS 
	PRIMARY KEY (curs_cd_curso)
;

ALTER TABLE app.Curso_Disciplina ADD CONSTRAINT PK_CURS_DISC 
	PRIMARY KEY (disc_cd_disciplina, curs_cd_curso)
;

ALTER TABLE app.Disciplina ADD CONSTRAINT PK_DISC 
	PRIMARY KEY (disc_cd_disciplina)
;

ALTER TABLE app.Inscricao ADD CONSTRAINT PK_INSC 
	PRIMARY KEY (insc_cd_inscricao)
;

ALTER TABLE app.Professor ADD CONSTRAINT PK_PROF 
	PRIMARY KEY (prof_cd_professor)
;

ALTER TABLE app.Telefone ADD CONSTRAINT PK_TELE 
	PRIMARY KEY (tele_cd_telefone)
;

ALTER TABLE app.Turma ADD CONSTRAINT PK_TURM 
	PRIMARY KEY (turm_cd_turma)
;


ALTER TABLE app.Aluno
	ADD CONSTRAINT UN_ALUN_CPF UNIQUE (alun_cd_cpf)
;

ALTER TABLE app.Inscricao
ADD CONSTRAINT CK_INSC_STATUS CHECK (insc_in_status in('PENDENTE','CANCELADA','CONFIRMADA'))
;

ALTER TABLE app.Professor
	ADD CONSTRAINT UN_PRO_CPF UNIQUE (prof_cd_cpf)
;

ALTER TABLE app.Telefone
ADD CONSTRAINT CK_TELE_TIPO_TELEFONE CHECK (tele_in_tipo_telefone IN('R','M','C','O'))
;

ALTER TABLE app.Turma
ADD CONSTRAINT CK_TURM_TURNO CHECK (turm_in_turno in('M','V','N'))
;


ALTER TABLE app.Aluno ADD CONSTRAINT FK_ALUN_CURS 
	FOREIGN KEY (curs_cd_curso) REFERENCES Curso (curs_cd_curso)
;

ALTER TABLE app.Curso_Disciplina ADD CONSTRAINT FK_CURS_CURS_DISC 
	FOREIGN KEY (curs_cd_curso) REFERENCES Curso (curs_cd_curso)
;

ALTER TABLE app.Curso_Disciplina ADD CONSTRAINT FK_DISC_CURS_DISC 
	FOREIGN KEY (disc_cd_disciplina) REFERENCES Disciplina (disc_cd_disciplina)
;

ALTER TABLE app.Inscricao ADD CONSTRAINT FK_ALUNO_INSC 
	FOREIGN KEY (alun_cd_aluno) REFERENCES Aluno (alun_cd_aluno)
;

ALTER TABLE app.Inscricao ADD CONSTRAINT FK_INSC_TURM 
	FOREIGN KEY (turm_cd_turma) REFERENCES Turma (turm_cd_turma)
;

ALTER TABLE app.Telefone ADD CONSTRAINT FK_PROF_TELE 
	FOREIGN KEY (prof_cd_professor) REFERENCES Professor (prof_cd_professor)
;

ALTER TABLE app.Turma ADD CONSTRAINT FK_TURM_PROF 
	FOREIGN KEY (prof_cd_professor) REFERENCES Professor (prof_cd_professor)
;

ALTER TABLE app.Turma ADD CONSTRAINT FK_Turma_Disciplina 
	FOREIGN KEY (disc_cd_disciplina) REFERENCES Disciplina (disc_cd_disciplina)
;


insert into app.curso (curs_cd_curso, curs_nm_curso, curs_tx_descricao) 
                       values (default, 'Engenharia Nuclear', 'Descrição do curso de Engenharia Nuclear');

insert into app.curso (curs_cd_curso, curs_nm_curso, curs_tx_descricao) 
                       values (default, 'Diplomacia', 'Descrição do curso de Diplomacia');

insert into app.disciplina (disc_cd_disciplina, disc_nm_disciplina, DISC_NT_CARG_HORARIO) 
                       values ('FISA', 'Física Sub-Atômica', 120);

insert into app.disciplina (disc_cd_disciplina, disc_nm_disciplina, DISC_NT_CARG_HORARIO) 
                       values ('OEUR',  'Oficina de Enriquecimento de Urânio', 60);

insert into app.disciplina (disc_cd_disciplina, disc_nm_disciplina, DISC_NT_CARG_HORARIO) 
                       values ('MOOG',  'Modelagem de Ogivas', 120);

insert into app.disciplina (disc_cd_disciplina, disc_nm_disciplina, DISC_NT_CARG_HORARIO) 
                       values ('RETO',  'Retórica', 120);

insert into app.disciplina (disc_cd_disciplina, disc_nm_disciplina, DISC_NT_CARG_HORARIO) 
                       values ('PRNO',  'Programação Neurolinguística', 120);

insert into app.Curso_Disciplina (disc_cd_disciplina, curs_cd_curso) 
                       values ('FISA', 1);

insert into app.Curso_Disciplina (disc_cd_disciplina, curs_cd_curso) 
                       values ('OEUR', 1);

insert into app.Curso_Disciplina (disc_cd_disciplina, curs_cd_curso) 
                       values ('MOOG', 1);

insert into app.Curso_Disciplina (disc_cd_disciplina, curs_cd_curso) 
                       values ('RETO', 2);

insert into app.Curso_Disciplina (disc_cd_disciplina, curs_cd_curso) 
                       values ('PRNO', 2);

insert into app.aluno (alun_cd_aluno, alun_nm_aluno, alun_cd_cpf, alun_nr_telefone, alun_tx_endereco, alun_nr_cep, alun_dt_nascimento, alun_in_sexo, curs_cd_curso) 
                       values (default, 'João', '12345678901', '5551234', 'Ruoa do Limoeiro, 32', '40000110', '1992-01-01 00:00:00', 'M', 1);

insert into app.aluno (alun_cd_aluno, alun_nm_aluno, alun_cd_cpf, alun_nr_telefone, alun_tx_endereco, alun_nr_cep, alun_dt_nascimento, alun_in_sexo, curs_cd_curso) 
                       values (default, 'Maria', '99999999999', '9991234', 'Rua do Céu, 23', '40000110', '1990-01-01 00:00:00', 'F', 1);

insert into app.aluno (alun_cd_aluno, alun_nm_aluno, alun_cd_cpf, alun_nr_telefone, alun_tx_endereco, alun_nr_cep, alun_dt_nascimento, alun_in_sexo, curs_cd_curso) 
                       values (default, 'Carlos', '00000000000', '2341234', 'Rua da Terra, 13', '40000110', '1994-01-01 00:00:00', 'M', null);

INSERT INTO app.PROFESSOR (PROF_CD_CPF, PROF_NM_PROFESSOR) 
	VALUES ('11111111111', 'Girafales');
INSERT INTO app.PROFESSOR (PROF_CD_CPF, PROF_NM_PROFESSOR) 
	VALUES ('22222222222', 'Raimundo');
INSERT INTO app.PROFESSOR (PROF_CD_CPF, PROF_NM_PROFESSOR) 
	VALUES ('33333333333', 'Dumbledore');

INSERT INTO app.TURMA (TURM_NR_VAGAS, TURM_NR_SALA, TURM_IN_TURNO, TURM_DT_PERIODO_INICIO, TURM_DT_PERIODO_FIM, TURM_TX_COMENTARIO, DISC_CD_DISCIPLINA, PROF_CD_PROFESSOR) 
	VALUES (12, 1, 0, '2015-02-18', '2015-06-17', 'Comentário da turma 1', 'FISA', 1);

INSERT INTO app.TURMA (TURM_NR_VAGAS, TURM_NR_SALA, TURM_IN_TURNO, TURM_DT_PERIODO_INICIO, TURM_DT_PERIODO_FIM, TURM_TX_COMENTARIO, DISC_CD_DISCIPLINA, PROF_CD_PROFESSOR) 
	VALUES (12, 1, 2, '2015-02-18', '2015-06-17', 'Turma da noite', 'FISA', 2);

INSERT INTO app.TURMA (TURM_NR_VAGAS, TURM_NR_SALA, TURM_IN_TURNO, TURM_DT_PERIODO_INICIO, TURM_DT_PERIODO_FIM, TURM_TX_COMENTARIO, DISC_CD_DISCIPLINA, PROF_CD_PROFESSOR) 
	VALUES (49, 2, 1, '2015-01-31', '2015-05-21', NULL, 'OEUR', 2);

INSERT INTO app.TURMA (TURM_NR_VAGAS, TURM_NR_SALA, TURM_IN_TURNO, TURM_DT_PERIODO_INICIO, TURM_DT_PERIODO_FIM, TURM_TX_COMENTARIO, DISC_CD_DISCIPLINA, PROF_CD_PROFESSOR) 
	VALUES (23, 2, 0, '2015-01-31', '2015-05-21', NULL, 'MOOG', 1);

INSERT INTO app.TURMA (TURM_NR_VAGAS, TURM_NR_SALA, TURM_IN_TURNO, TURM_DT_PERIODO_INICIO, TURM_DT_PERIODO_FIM, TURM_TX_COMENTARIO, DISC_CD_DISCIPLINA, PROF_CD_PROFESSOR) 
	VALUES (23, 5, 0, '2015-01-31', '2015-05-21', NULL, 'RETO', 3);

INSERT INTO app.TURMA (TURM_NR_VAGAS, TURM_NR_SALA, TURM_IN_TURNO, TURM_DT_PERIODO_INICIO, TURM_DT_PERIODO_FIM, TURM_TX_COMENTARIO, DISC_CD_DISCIPLINA, PROF_CD_PROFESSOR) 
	VALUES (23, 5, 1, '2015-01-31', '2015-05-21', NULL, 'PRNO', 3);

INSERT INTO app.INSCRICAO (INSC_DT_INSCRICAO, INSC_IN_STATUS, ALUN_CD_ALUNO, TURM_CD_TURMA) 
	VALUES ('2015-01-14 13:41:54.226', 'PENDENTE', 1, 1);
INSERT INTO app.INSCRICAO (INSC_DT_INSCRICAO, INSC_IN_STATUS, ALUN_CD_ALUNO, TURM_CD_TURMA) 
	VALUES ('2015-01-14 13:42:06.611', 'PENDENTE', 1, 3);