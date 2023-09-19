import kotlin.math.round
import kotlin.random.Random

enum class PowerUps {
    PRIMARYBOOST,
    SECONDARYBOOST,
    WARFRAMEBOOST,

}

data class Tenno(
    val name: String,
    val healthTenno: Int,
    val armorTenno: Int,
    val shieldTenno: Int,
    val speedTenno: Int,
    val levelTenno: Int,
    val currentXPTenno: Int,
    val xpCapTenno: Int,
) {

    var defaultHealth = healthTenno
    var defaultShields = shieldTenno

    var shield = shieldTenno
    var health = healthTenno

    fun attack(enemy: Enemy, weapons: SealedRangedWeapons): Enemy {
        var i = 1
        var currentAccuracy = weapons.weaponAccuracy
        val criticalResult = weapons.checkCritical(weapons.criticalChance)
        val damageDealt = weapons.calculateDPS(criticalResult)
        val hitChanceRoll = Random.nextInt(1, 100)
        if (hitChanceRoll <= currentAccuracy) {
            enemy.damageReceive(damageDealt)
            currentAccuracy -= weapons.weaponRecoil
        } else {
        }
        i++

        return enemy.copy(healthEnemy = enemy.currentHP, shieldEnemy = enemy.currentShield)
    }

    fun dodgeAttack(speedTenno: Int, enemy: Enemy): Boolean {
        val dodgeChance = Random.nextInt(1, 100)
        val dodged = dodgeChance < speedTenno
        return dodged
    }

    fun damageReceive(damage: Int): Tenno {
        if (shieldTenno > 0) {
            val remainingDamage = damage - shieldTenno
            if (remainingDamage <= shieldTenno) {
                shield -= damage
            } else {
                shield = 0
            }
        } else {
            val damageReduced = damage - (damage * armorTenno / 100)
            health -= damageReduced
        }
        if (health < 0) {
            health = 0
        }
        return Tenno(
            name,
            health,
            armorTenno,
            shield,
            speedTenno,
            levelTenno,
            currentXPTenno,
            xpCapTenno
        )
    }

//    fun levellingUp(tenno: Tenno, primaryWeapon: PrimaryWeapon, secondaryWeapon: SecondaryWeapon) = copy(){
//        var levelledUp = false
//        if (currentXPTenno >= xpCapTenno){
//            levelTenno += 1
//            currentXPTenno = 0
//            xpCapTenno += 10
//            levelledUp = true
//            println("Select An Upgrade: ")
//            for (upgrade in enumValues<PowerUps>()){
//                println("${upgrade.ordinal+1}) $upgrade")
//            }
//            val upgradeChoice = readlnOrNull()?.toIntOrNull()
//            when(upgradeChoice){
//                1 -> {
//                    primaryWeapon.baseDamage += 2
//                    primaryWeapon.criticalChance += 5
//                    primaryWeapon.weaponAccuracy += 5
//                    primaryWeapon.weaponRecoil -= 1
//                }
//                2 -> {
//                    secondaryWeapon.baseDamage += 2
//                    secondaryWeapon.criticalChance += 5
//                    secondaryWeapon.weaponAccuracy += 5
//                    secondaryWeapon.weaponRecoil -= 1
//                }
//                3 -> {
//                    healthTenno = defaultHealth + 10
//                    armorTenno += 5
//                    shieldTenno = defaultShields+ 15
//                    speedTenno += 5
//                    defaultHealth = healthTenno
//                    defaultShields = shieldTenno
//                }
//                else -> {
//                    healthTenno = defaultHealth + 10
//                    armorTenno += 5
//                    shieldTenno = defaultShields+ 15
//                    speedTenno += 5
//                }
//            }
//            healthTenno = defaultHealth
//            shieldTenno = defaultShields
//            return levelledUp
//        }
//        else{
//            return levelledUp
//        }
//    }

    fun alive(): Boolean {
        return health > 0
    }

    fun tennoShieldRegen() : Tenno {
        shield = defaultShields
        return copy(shieldTenno = shield)
    }

}