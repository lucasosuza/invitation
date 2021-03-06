package com.lucassouza;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    private static final InvitationService invitationService = new InvitationService();

    public static void main(String[] args) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(args[0]));

            invitationService.getInvitations(allLines).forEach(System.out::println);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}