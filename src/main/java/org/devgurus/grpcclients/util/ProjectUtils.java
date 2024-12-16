package org.devgurus.grpcclients.util;

import org.devgurus.grpcclients.dto.ClientRequest;

public class ProjectUtils {

    public static boolean isValidRoute(String route) {
        try {
            ClientRequest.RouteEnum.valueOf(route);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
