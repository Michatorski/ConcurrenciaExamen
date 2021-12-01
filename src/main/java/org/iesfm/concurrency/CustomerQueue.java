package org.iesfm.concurrency;

/**
 * Esta clase representa a la cola de clientes
 */
public class CustomerQueue {
    private int size;

    public CustomerQueue(int size) {
        this.size = size;
    }

    /**
     * Este método quita un cliente de la cola. Está sincronizado para que no haya dos threads que lo modifiquen
     * al mismo tiempo
     */
    public synchronized void decrementQueue(){
        size--;
    }


    public int getSize() {
        return size;
    }
}
