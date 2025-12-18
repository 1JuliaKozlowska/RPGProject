package Interfaces;

import GameEntities.Attack;
import Items.RPGArmor;
import Items.RPGRing;
import Items.RPGWeapon;

import java.util.ArrayList;

public interface IGameEntity {
    String getName();
    String getDescription();
    Attack[] getAttacks();
    RPGWeapon getEquippedWeapon();
    RPGArmor getEquippedArmor();
    RPGRing getEquippedRing();
}
