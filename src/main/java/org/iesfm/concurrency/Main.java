package org.iesfm.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        log.info("Indica cuántos clientes hay en la cola...");
        int size = readPositiveInt();

        CustomerQueue queue = new CustomerQueue(size);

        Thread cash1 = new Thread(new CashierTask(queue));
        Thread cash2 = new Thread(new CashierTask(queue));

        cash1.start();
        cash2.start();

        try {
            cash1.join();
            cash2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Cola vacía");

    }

    private static int readInt() {
        Integer number = null;

        while (number == null) {
            try {
                number = scanner.nextInt();
            } catch (InputMismatchException e) {
                log.error("¡Debe introducir un numero!");
            } finally {
                scanner.nextLine();
            }
        }
        return number;
    }

    private static int readPositiveInt(){
        int number = readInt();
        while (number < 0){
            log.error("¡Debe introducir un numero positivo!");
            number = readInt();
        }
        return number;
    }
}
