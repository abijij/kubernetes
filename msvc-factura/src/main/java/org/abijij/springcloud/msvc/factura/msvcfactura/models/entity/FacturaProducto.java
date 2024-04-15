package org.abijij.springcloud.msvc.factura.msvcfactura.models.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "facturahasproducto")
public class FacturaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productos_ids" , unique = true)
    private List<Long> productosIds;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public List<Long> getProductosIds() {
        return productosIds;
    }

    public void setProductosIds(List<Long> productosIds) {
        this.productosIds = productosIds;
    }

    @Override
    public boolean equals(Object obj) {
         if (this == obj){
             return true;
         }
         if (!(obj instanceof FacturaProducto)){
             return  false;

         }
         FacturaProducto f = (FacturaProducto) obj;
         return this.productosIds != null && this.productosIds.equals(f.productosIds);
    }
}
