package gg.kisruimc.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandHandler {

    String name() default "";

    String permission() default "None";

    String description() default "Default Description";

    String usage() default "None";

    String[] aliases() default "None";

}
