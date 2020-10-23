package customers.Customerservice.projection;

import customers.Customerservice.model.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomer",types = Customer.class)
public interface customerProjection  extends Projection{
    public Long getId();
    public String getName();
    public String getEmail();
}