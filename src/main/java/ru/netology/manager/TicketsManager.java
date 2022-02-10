package ru.netology.manager;

import lombok.RequiredArgsConstructor;
import ru.netology.domain.TicketsInfo;
import ru.netology.repository.Repository;

import java.util.Arrays;

@RequiredArgsConstructor

public class TicketsManager {
    private Repository repo = new Repository();

    public void save (TicketsInfo ticketsInfo) {
        repo.save(ticketsInfo);
    }

    public TicketsInfo[] searchBy(String to, String from) {
        TicketsInfo[] result= new TicketsInfo[0];
        for (TicketsInfo item : repo.findAll()){
            if(item.getPortOut().equalsIgnoreCase(to) & item.getPortIn().equalsIgnoreCase(from)) {
                TicketsInfo[] tmp = new TicketsInfo[result.length +1];
                System.arraycopy(result,0,tmp,0,result.length);
                tmp[tmp.length-1]=item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public void remove (int id) {
        repo.removeById(id);
    }

}
