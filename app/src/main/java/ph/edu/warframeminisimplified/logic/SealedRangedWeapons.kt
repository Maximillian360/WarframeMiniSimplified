import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlin.random.Random


sealed class SealedRangedWeapons() {
    abstract val name: String
    abstract val baseDamage: Int
    abstract val multiShot: Int
    abstract val fireRate: Int
    abstract val criticalChance: Int
    abstract val criticalDamage: Int
    abstract val weaponAccuracy: Int
    abstract val weaponRecoil: Int
    abstract val weaponRange: Int

    val MIN_RANDOM_VALUE = 1
    val MAX_RANDOM_VALUE = 400
    val YELLOW_CRITICALS = 100
    val ORANGE_CRITICALS = 200
    val RED_CRITICALS = 300

    fun checkCritical(criticalChance: Int): String {
        val RANDOM_NUMBER  = Random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE)
        return when {
            (RANDOM_NUMBER >= criticalChance + YELLOW_CRITICALS && RANDOM_NUMBER <= criticalChance + ORANGE_CRITICALS) -> "Yellow Critical"
            (RANDOM_NUMBER >= criticalChance + ORANGE_CRITICALS && RANDOM_NUMBER <= criticalChance + RED_CRITICALS) -> "Orange Critical"
            (RANDOM_NUMBER >= criticalChance + RED_CRITICALS) -> "Red Critical"
            else -> "No Critical"
        }
    }

    fun calculateDPS(criticalResult: String): Int =
        when (criticalResult) {
            "Yellow Critical" -> (fireRate * baseDamage * multiShot * (1 + criticalDamage))
            "Orange Critical" -> (fireRate * baseDamage * multiShot *(2 + criticalDamage))
            "Red Critical" -> (fireRate *baseDamage * multiShot * (3 + criticalDamage))
            else -> (fireRate * baseDamage * multiShot)
        }
}

data class PrimaryWeapon(
    override val name: String,
    override val baseDamage: Int,
    override val multiShot: Int,
    override val fireRate: Int,
    override val criticalChance: Int,
    override val criticalDamage: Int,
    override val weaponAccuracy: Int,
    override val weaponRecoil: Int,
    override val weaponRange: Int

) : SealedRangedWeapons(){
    companion object{
        val BRATON = PrimaryWeapon("Braton", 2, 2, 3, 15, 2, 80, 5, 2)
        val PARIS = PrimaryWeapon("Paris", 6, 2, 1, 25, 5, 65, 10, 3)
        val FLUXRIFLE = PrimaryWeapon("Flux Rifle", 1, 2, 3, 12, 2, 75, 3, 2)
        val HEK = PrimaryWeapon("Hek",3, 3, 2, 20, 3, 100, 50, 2)
        val KOMOREX = PrimaryWeapon("Komorex", 4, 2, 1, 25, 3, 95, 5, 3)
        val GLAXION = PrimaryWeapon("Glaxion", 1, 2, 3, 15, 2, 80, 5, 2)
    }
}

class SecondaryWeapon(
    override val name: String,
    override val baseDamage: Int,
    override val multiShot: Int,
    override val fireRate: Int,
    override val criticalChance: Int,
    override val criticalDamage: Int,
    override val weaponAccuracy: Int,
    override val weaponRecoil: Int,
    override val weaponRange: Int

) : SealedRangedWeapons(){
    companion object{
            val LATO = SecondaryWeapon("Lato", 5, 1, 3, 30, 4, 100, 10, 1)
            val MAGNUS = SecondaryWeapon("Magnus",  7, 1, 1, 35, 4, 75, 15, 1)
            val DETRON = SecondaryWeapon("Detron",  3, 3, 3, 25, 3, 60, 2, 1)
            val BRAKK = SecondaryWeapon("Brakk",   2, 3, 2, 30, 3, 100, 20, 1)
        val STUG = SecondaryWeapon("Stug", 1, 1, 1, 1, 1, 2, 50, 1)
    }
}


