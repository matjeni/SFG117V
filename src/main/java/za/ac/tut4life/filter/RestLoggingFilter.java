package za.ac.tut4life.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.cglib.core.internal.Function;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import za.ac.tut4life.util.LoggerUtil;

import java.io.*;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.util.Collections.list;

@Configuration
@Component
@Order(2)
public class RestLoggingFilter implements Filter {
    LoggerUtil LOG = new LoggerUtil();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException {

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(
                                                            (HttpServletRequest) servletRequest);
        ContentCachingResponseWrapper responseCacheWrapperObject = new ContentCachingResponseWrapper(
                                                                        (HttpServletResponse) servletResponse);
        long start = System.currentTimeMillis();
        try {
            filterChain.doFilter(requestWrapper, responseCacheWrapperObject);
        }catch (Exception e){
            LOG.error("oops error %s", e);
        } finally {
            REQUEST(requestWrapper);
            byte[] responseArray = responseCacheWrapperObject.getContentAsByteArray();
            String responseStr = new String(responseArray, responseCacheWrapperObject.getCharacterEncoding());
            responseCacheWrapperObject.copyBodyToResponse();
            LOG.info("response {}", responseStr);
        }
        long elapsed= System.currentTimeMillis() - start;
        LOG.info("request elapsed time "+elapsed +" ms");

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private void REQUEST(ContentCachingRequestWrapper request) {
        StringBuilder builder = new StringBuilder();
        // Append headers
        builder.append("\n").append(headersToString(list(request.getHeaderNames()), request::getHeader)).append("\n");
        // Append request body
        builder.append(new String(request.getContentAsByteArray()));
        // Log the request
        LOG.info("Request: {}\n"+builder);

    }

    private String headersToString(Collection<String> headerNames, Function<String, String> headerValueResolver) {
        return headerNames.stream()
                .map(headerName -> "%s=%s".formatted(headerName, headerValueResolver.apply(headerName)))
                .collect(Collectors.joining("\n"));
    }

}
