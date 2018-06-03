package com.spacefox.frida.propdb;

import com.spacefox.frida.domain.Discount;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataDiscount {

    private PropertiesConfiguration props;
    private int discAmount;
    private List<Discount> discounts;

    public List<Discount> getAll() {
        return discounts;
    }

    public Discount getByName(String name) {
        return discounts.stream().filter(dis -> dis.getName().equals(name)).findFirst().get();
    }

    public DataDiscount() throws ConfigurationException {
        props = new PropertiesConfiguration("dummyData.properties");
        init();
    }

    //    @PostConstruct
    private void init(){
        discAmount = props.getInt("disc.amount");
        discounts = new ArrayList<>();

        for(int i=1; i < discAmount+1; i++){
            Discount disc = new Discount();
            disc.setName(props.getString(i + ".Discount.Name"));
            disc.setDiscountFactor(props.getInt(i + ".Discount.Factor"));
            disc.setDescription(props.getString(i + ".Discount.Desc"));
            discounts.add(disc);
        }
    }

}
