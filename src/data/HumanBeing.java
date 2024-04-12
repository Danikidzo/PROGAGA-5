package data;

import java.io.Serializable;
import java.time.LocalDateTime;

public final class HumanBeing implements Comparable<HumanBeing>, Serializable {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private boolean realHero;
    private Boolean hasToothpick; //Поле может быть null
    private float impactSpeed;
    private WeaponType weaponType; //Поле может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле не может быть null

    private HumanBeing() {
        //private constructor
    }
    public String getName() {return name;}
    @Override
    public int compareTo(HumanBeing o) {
        if (o.getImpactSpeed() - this.getImpactSpeed() != 0) {
            return (int) (this.getImpactSpeed() - o.getImpactSpeed());
        } else {
            return this.getName().length() - o.getName().length();
        }
    }

    public long getId() {return id;}
    public void setId(Long id) {
        this.id = id;
    }


    public Coordinates getCoordinates() {return coordinates;}

    public LocalDateTime getCreationDate() {return creationDate;}

    public boolean isRealHero() {return realHero;}

    public Boolean getHasToothpick() {return hasToothpick;}

    public float getImpactSpeed() {return impactSpeed;}

    public WeaponType getWeaponType() {return weaponType;}

    public Mood getMood() {return mood;}

    public Car getCar() {return car;}


    @Override
    public String toString() {
        return "HumanBeing" +
                "\nid=" + id +
                "\nname='" + name +
                "\ncoordinates=" + coordinates +
                "\ncreationDate=" + creationDate +
                "\nrealHero=" + realHero +
                "\nhasToothpick=" + hasToothpick +
                "\nimpactSpeed=" + impactSpeed +
                "\nweaponType=" + weaponType +
                "\nmood=" + mood +
                "\ncar=" + car ;
    }

    public static HumanBeingBuilder newBuilder() {
        return new HumanBeing().new HumanBeingBuilder();
    }

    public final class HumanBeingBuilder {
        public HumanBeingBuilder id(Long sameId) {
            HumanBeing.this.id = sameId;
            return this;
        }
        public HumanBeingBuilder setName(String name) {
            HumanBeing.this.name = name;
            return this;
        }
        public HumanBeingBuilder setCoordinates(Coordinates coordinates) {
            HumanBeing.this.coordinates = coordinates;
            return this;
        }
        public HumanBeingBuilder creationDate(LocalDateTime CreationDate) {
            HumanBeing.this.creationDate = CreationDate;
            return this;
        }
        public HumanBeingBuilder setRealHero(boolean realHero) {
            HumanBeing.this.realHero = realHero;
            return this;
        }
        public HumanBeingBuilder setHasToothpick(Boolean hasToothpick) {
            HumanBeing.this.hasToothpick = hasToothpick;
            return this;
        }
        public HumanBeingBuilder setImpactSpeed(float impactSpeed) {
            HumanBeing.this.impactSpeed = impactSpeed;
            return this;
        }
        public HumanBeingBuilder setWeaponType(WeaponType weaponType) {
            HumanBeing.this.weaponType = weaponType;
            return this;
        }
        public HumanBeingBuilder setMood(Mood mood) {
            HumanBeing.this.mood = mood;
            return this;
        }
        public HumanBeingBuilder setCar(Car car) {
            HumanBeing.this.car = car;
            return this;
        }
        public HumanBeing build() {return HumanBeing.this;}
    }
}