package code;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Cart {
    private List<Item> items;
    private Double totalPrice;

    public Cart() {
        items = new ArrayList<>();
        totalPrice = 0.0;

    }

    void addItem(Item item){
        items.add(item);
        totalPrice += item.getPrice();
    }

    Map<String,Double> getItemizedList(){
        Map<String, Double> itemList = items
                .stream()
                .collect(Collectors.groupingBy(Item::getName,summingDouble(Item::getPrice)));

        return itemList;
    }

    Map<String,Long> getItemizedQuantity(){
        return  items.stream()
                .collect(groupingBy(Item::getName, counting()));
    }
    Map<String, DoubleSummaryStatistics> getItemSummary(){
        return items.stream().collect(groupingBy(Item::getName,summarizingDouble(Item::getPrice)));
    }

    String getItemizedListString(){
        return getItemizedList().entrySet().stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .collect(Collectors.joining(" , \n"));
    }

    String getItemizedSummaryString(){
        return getItemSummary().entrySet().stream()
                .map(e -> e.getKey() + " quanitity : " + e.getValue().getCount() + " price : " +e.getValue().getSum() )
                .collect(joining(" , \n"));
    }
}
