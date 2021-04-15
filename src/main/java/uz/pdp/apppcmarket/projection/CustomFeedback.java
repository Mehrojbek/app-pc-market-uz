package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Feedback;

@Projection(types = Feedback.class)
public interface CustomFeedback {

    Integer getId();

    String getComment();

    String getEmail();

    String getName();

}
