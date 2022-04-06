package features.readFridge.services;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import features.readFridge.helpers.MessageHelper;
import models.fridge.Fridge;
import models.fridge.Item;
import models.fridge.ItemDto;
import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

@Service
public class ParseFridgeItemService {
    public OperationResultMessage<Fridge> parse(String input) {
        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            CSVReader reader = new CSVReader(new StringReader(input));
            CsvToBean<ItemDto> csToBean = new CsvToBeanBuilder(reader).withType(ItemDto.class).build();
            Iterator<ItemDto> iterator = csToBean.iterator();
            ArrayList<Item> items = new ArrayList<>();

            while (iterator.hasNext()) {
                ItemDto item = iterator.next();
                items.add(new Item(item.getItem(), item.getAmount(), item.getUnit(), LocalDate.parse(item.getUseBy(), formatter)));
            }
            Fridge result = new Fridge();
            result.setItems(items);
            return new OperationResultMessage<>(OperationResultStatus.SUCCESS, StringHelper.EMPTY_STRING, result);
        } catch (Exception e) {
            return new OperationResultMessage<>(OperationResultStatus.ERROR, MessageHelper.invalidFormat(input), null);
        }

    }
}
