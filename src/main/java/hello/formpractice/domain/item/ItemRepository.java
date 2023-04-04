package hello.formpractice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();   //static
    private static long sequence = 0L;                              //static

    public Item save(Item item) {
        item.setId(++sequence);         //저장될때마다 시퀀스 +1
        store.put(item.getId(), item);  //store(Map)객체에 id와 item 집어넣기
        return item;                     //item정보 리턴
    }

    public Item findById(Long id) {
        return store.get(id);           //id가 일치하는 store객체 리턴
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values()); //전체 store객체의 정보를 List에 담아서 리턴
    }
    
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
        findItem.setOpen(updateParam.getOpen());
        findItem.setRegions(updateParam.getRegions());
        findItem.setDeliveryCode(updateParam.getDeliveryCode());
        findItem.setItemType(updateParam.getItemType());
    }
    
    public void clearStore() {
        store.clear();                          //store객체 비우기
    }
}
