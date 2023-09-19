import kotlin.random.Random

data class Enemy(
    val name: String,
    val healthEnemy: Int,
    val shieldEnemy: Int,
    val shieldRegen: Int,
    val xpProvidedEnemy: Int = 25,
    val levelEnemy: Int = 1,
    val xpToLevelUpEnemy: Int,
    val enemyWeapon: PrimaryWeapon
) {

    var currentShield = shieldEnemy
    var currentHP = healthEnemy
    fun attack(tenno: Tenno, weapon: PrimaryWeapon): Tenno {
        var currentAccuracy = weapon.weaponAccuracy
        val criticalResult = weapon.checkCritical(weapon.criticalChance)
        val damageDealt = weapon.calculateDPS(criticalResult)
        val hitChanceRoll = Random.nextInt(1, 100)
        if (hitChanceRoll <= currentAccuracy) {
            //println("----------------------------------------------------------------------------------")
            tenno.damageReceive(damageDealt)
            currentAccuracy -= weapon.weaponRecoil
        } else {
            //println("----------------------------------------------------------------------------------")
            //println("$name missed! ${tenno.name} receives no damage!")
        }
        return tenno.copy(healthTenno = tenno.defaultHealth, shieldTenno = tenno.defaultShields)
    }

    fun damageReceive(damage: Int): Enemy {
        if (currentShield > 0) {
            //val remainingDamage = damage - currentHP
            if (damage <= 0) {
                currentShield -= damage
            } else {
                currentShield = 0
            }
        } else {
            currentHP -= damage
        }
        if (currentHP < 0) {
            currentHP = 0
        }
        return Enemy(
            name,
            currentHP,
            currentShield,
            shieldRegen,
            xpProvidedEnemy,
            levelEnemy,
            xpToLevelUpEnemy,
            enemyWeapon
        )
        //println("$name takes $damage damage. Current Shields: $shieldEnemy/$defaultShield HP: $healthEnemy/$defaultHP")
    }

    fun shieldRegen(): Enemy {
        currentShield = shieldEnemy
        return copy(shieldEnemy = currentShield)
    }

    fun alive(): Boolean {
        return currentHP > 0
    }
}
