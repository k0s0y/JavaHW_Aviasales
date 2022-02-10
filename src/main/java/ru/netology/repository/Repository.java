package ru.netology.repository;

import ru.netology.domain.NegativeIdException;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.TicketsInfo;

public class Repository {
    private TicketsInfo[] items = new TicketsInfo[0];

    public void save(TicketsInfo item) {
        int length = items.length + 1;
        TicketsInfo[] tmp = new TicketsInfo[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }



    public TicketsInfo findById(int id) {
        for (TicketsInfo item : items) {
            if (item.getId() == id) {
                return item;
            }
//            else {
//                throw new NotFoundException("Element with id: " + id + " not found");
//            }
        }
        return null;
    }

    public TicketsInfo[] getAll() {
        TicketsInfo[] result = new TicketsInfo[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        if (id<0)
            throw new NegativeIdException("Element with id: " + id + " have negative volume");
        if (findById(id) == null)
            throw new NotFoundException("Element with id: " + id + " not found");
        int length = items.length - 1;
        TicketsInfo[] tmp = new TicketsInfo[length];
        int index = 0;
        for (TicketsInfo item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public TicketsInfo[] findAll() {
        return items;
    }

}
