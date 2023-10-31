package com.greyog.transaqclientspring3.component;

import com.greyog.transaqclientspring3.entity.message.FortsPosition;
import com.greyog.transaqclientspring3.entity.message.Positions;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Position {

    private Positions positions;

    private FortsPosition fortsPosition;
}
