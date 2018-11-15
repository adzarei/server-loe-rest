package adzarei.loe.webfirma.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCommand {

    private Long id;
    private String email;
    private String password;

}
