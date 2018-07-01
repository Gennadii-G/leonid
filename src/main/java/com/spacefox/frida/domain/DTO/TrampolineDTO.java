package com.spacefox.frida.domain.DTO;

import com.spacefox.frida.domain.catalogs.TrampolineType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class TrampolineDTO {

    private boolean isBroken;
    private boolean isOrdered;
    private TrampolineType type;
}
