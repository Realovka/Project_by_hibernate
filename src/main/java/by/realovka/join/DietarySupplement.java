package by.realovka.join;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "dietary_supplement_join")
@DiscriminatorValue("dietary_supplement")
public class DietarySupplement extends Product {
    @Column(name = "package_division")
    private Boolean packageDivision;
    @Column(name = "belarusian_product")
    private Boolean belarusianProduct;
}
