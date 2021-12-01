package org.iesfm.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Esta clase representa las cajas del supermercado. Cada caja se ejecuta en un hilo y va quitando clientes hasta
 * que no queda ninguno
 */
public class CashierTask implements Runnable {
    private final Logger log = LoggerFactory.getLogger(CashierTask.class);

    private CustomerQueue queue;

    public CashierTask(CustomerQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        // Mientras queden clientes en la cola
        while (queue.getSize() > 0) {
            // Quitamos un cliente y continuamos
            queue.decrementQueue();
            log.info("Cliente servido!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


