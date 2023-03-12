/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.interceptor;

import ec.edu.monster.interceptorbinding.InterceptorInicioSesionBinding;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author santi
 */
@InterceptorInicioSesionBinding
@Interceptor
public class InicioSesionInterceptor {

    private static final Logger logger = Logger.getLogger(InicioSesionInterceptor.class.getName());

    @AroundInvoke
    public Object logMethodCall(InvocationContext invocationContext) throws Exception {
        logger.log(Level.INFO, new StringBuilder("Entrando ").append(invocationContext.getMethod().getName()).append(" method").toString());
        Object retVal = invocationContext.proceed();
        logger.log(Level.INFO, new StringBuilder("Saliendo ").append(invocationContext.getMethod().getName()).append(" method").toString());
        return retVal;
    }
}
