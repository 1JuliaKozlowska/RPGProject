package Interfaces;

import GameEntities.Attack;
import Items.RPGArmor;
import Items.RPGRing;
import Items.RPGWeapon;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;

public interface IGameEntity {
    String getName();
    String getDescription();
    Attack[] getAttacks();

    RPGWeapon getEquippedWeapon();
    RPGArmor getEquippedArmor();
    RPGRing getEquippedRing();

    int getBaseDamage();
    int getBaseHealth();
    int getBaseDefense();

    int getDamage();
    int getHealth();
    int getDefense();

    String getASCIIArt(int line);
}
