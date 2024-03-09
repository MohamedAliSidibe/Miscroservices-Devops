package InventoryService.InventoryService.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullinventory",types = Product.class)
public interface ProductProjection extends Projection {
    public Long getId();
    public String getName();
    public double getPrice();

    //Full projction va nous permettre de specifier quell
    //champ seraenvoyer durant le corps de l'API
}
