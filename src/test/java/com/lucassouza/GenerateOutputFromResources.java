package com.lucassouza;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class GenerateOutputFromResources {

    private static final InvitationService invitationService = new InvitationService();

    public static void main(String[] args) {
        try {
            URL resource = Application.class.getClassLoader().getResource("customers.txt");
            List<String> allLines = Files.readAllLines(Paths.get(resource.toURI()));

            invitationService.getInvitations(allLines).forEach(System.out::println);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}