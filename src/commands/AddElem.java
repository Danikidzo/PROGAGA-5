package commands;

import utility.*;
import data.*;

import java.time.LocalDateTime;

public final class AddElem {
    public static HumanBeing add(boolean newId, UserInputManager userInputManager, OutputManager outputManager, CollectionManager collectionManager) {
        Coordinates.CoordinatesBuilder coordinatesBuilder = Coordinates.newBuilder();
        coordinatesBuilder.setX(userInputManager.readLongValue(" x(coordinates)", outputManager, "Check x dataFormat, please"));
        coordinatesBuilder.setY(userInputManager.readFloatValue(" y(coordinates)", outputManager, "Check y dataFormat, please"));

        Car car;
        Car.CarBuilder carBuilder = Car.newBuilder();
        carBuilder.cool(userInputManager.readBooleanValue(" cool(Car, dataFormat: Boolean)", outputManager, "Check cool dataFormat, please"));
        car = carBuilder.build();

        HumanBeing.HumanBeingBuilder humanBeingBuilder = HumanBeing.newBuilder();
        humanBeingBuilder.setName(userInputManager.readStringNameValue(" name(HumanBeing, dataFormat: String)", outputManager, "Field can't be null, String can't be empty"));
        humanBeingBuilder.setCar(car);
        humanBeingBuilder.setCoordinates(coordinatesBuilder.build());
        humanBeingBuilder.setImpactSpeed(userInputManager.readFloatValue(" impactSpeed(HumanBeing, dataFormat: float)", outputManager, "Check impact speed dataFormat, please"));
        humanBeingBuilder.setRealHero(userInputManager.readBooleanValue(" realHero(HumanBeing, dataFormat: boolean)", outputManager, "Check real hero dataFormat, please"));
        humanBeingBuilder.setHasToothpick(userInputManager.readBooleanValue(" hasToothpick(HumanBeing, dataFormat: boolean)", outputManager, "Check 'has Toothpick' dataFormat, please"));
        humanBeingBuilder.setWeaponType(userInputManager.readWeaponType(" HAMMER or RIFLE or PISTOL(dataFormat: WeaponType)", outputManager, "Check weapon type dataFormat, please"));
        humanBeingBuilder.setMood(userInputManager.readMood(" GLOOM or APATHY or FRENZY (dataFormat: Mood)", outputManager, "Check mood dataFormat, please"));
        if (newId) {
            humanBeingBuilder.setId(collectionManager.getNewID());
        } else {
            humanBeingBuilder.setId(1L);
        }
        humanBeingBuilder.creationDate(LocalDateTime.now());
        return humanBeingBuilder.build();
    }
}
