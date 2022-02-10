package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NegativeIdException;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.TicketsInfo;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
    private TicketsManager manager = new TicketsManager();
    private TicketsInfo item1 = new TicketsInfo(1, 88888, "DME", "JFK", 123);
    private TicketsInfo item2 = new TicketsInfo(2, 250000, "DME", "SVO", 523);
    private TicketsInfo item3 = new TicketsInfo(3, 13000, "DME", "JFK", 678);
    private TicketsInfo item4 = new TicketsInfo(4, 900000, "DME", "SVO", 39);
    private TicketsInfo item5 = new TicketsInfo(5, 900, "SVO", "JFK", 342);
    private TicketsInfo item6 = new TicketsInfo(6, 10000, "JFK", "SVO", 938);
    private TicketsInfo item7 = new TicketsInfo(7, 900000, "JFK", "SVO", 982);
    private TicketsInfo item8 = new TicketsInfo(8, 12312, "JFK", "SVO", 892);
    private TicketsInfo item9 = new TicketsInfo(9, 5000, "JFK", "SVO", 984);

   @BeforeEach
    public void setup() {
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.save(item5);
        manager.save(item6);
        manager.save(item7);
        manager.save(item8);
        manager.save(item9);
    }

    @Test
    public void sortByPrice() {
        TicketsInfo[] expected = new TicketsInfo[]{item5, item9, item6, item8, item3, item1, item2, item4, item7};
        TicketsInfo[] actual = new TicketsInfo[]{item1, item2, item3, item4, item5, item6, item7, item8, item9};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void notTicketLikeRequest() {
       TicketsInfo[] expected = new TicketsInfo[]{};
       TicketsInfo[] actual = manager.searchBy("SVO", "DME");
       assertArrayEquals(expected, actual);
    }

    @Test
    public void giveTicketLikeRequest() {
        TicketsInfo[] expected = new TicketsInfo[]{item9, item6, item8, item7};
        TicketsInfo[] actual = manager.searchBy("JFK","SVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void giveTicketLikeRequestlowerCase() {
        TicketsInfo[] expected = new TicketsInfo[]{item9, item6, item8, item7};
        TicketsInfo[] actual = manager.searchBy("jfk","svo");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOne(){
        TicketsInfo[] expected = new TicketsInfo[]{item5};
        TicketsInfo[] actual = manager.searchBy("SVO","jfk");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchInListFromOneValue() {
       TicketsManager manager = new TicketsManager();
       manager.save(item1);
       TicketsInfo[] expected = new TicketsInfo[]{item1};
       TicketsInfo[] actual = manager.searchBy("DME","jfk");
       assertArrayEquals(expected, actual);
    }

    @Test
    public void searchInEmptyList() {
        TicketsManager manager = new TicketsManager();
        TicketsInfo[] expected = new TicketsInfo[]{};
        TicketsInfo[] actual = manager.searchBy("DME","jfk");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        manager.remove(6);
        TicketsInfo[] expected = new TicketsInfo[]{item9, item8, item7};
        TicketsInfo[] actual = manager.searchBy("JFK","SVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNegativeId() {
       assertThrows(NegativeIdException.class,() ->{manager.remove(-1);});
    }

    @Test
    public void removeWrongId() {
        assertThrows(NotFoundException.class,() ->{manager.remove(22);});
    }

}