package org.morgade.sysacad.infrastructure.jsonrpc;

import com.fasterxml.jackson.databind.JsonNode;
import com.googlecode.jsonrpc4j.ErrorResolver.JsonError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.http.HttpStatus;

/**
 *
 */
public class ErrorResolver implements com.googlecode.jsonrpc4j.ErrorResolver {

    @Override
    public JsonError resolveError(Throwable t, Method method, List<JsonNode> list) {
        Throwable cleanException = cleanException(t);
        String message = cleanException.getMessage();
        message += "(" + cleanException.getClass().getName() + ")";
        JsonError jsonError = new JsonError(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, cleanException.getStackTrace());
        return jsonError;
    }

    public static Throwable cleanException(Throwable t) {
        Throwable ex = t;
        while (ex != null && ex.getCause() != null
                && ((ex instanceof InvocationTargetException)
                || (ex instanceof UndeclaredThrowableException)
                || (ex instanceof ExecutionException))) {
            ex = ex.getCause();
        }
        return ex;
    }

}
