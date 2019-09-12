package tank.main.consts;

/**
 * @author henengqiang
 * @date 2019/09/09
 */
public enum AwardTypeEnum {

    /**
     * 加血加火力
     */
    ADD_BLOOD_FIRE(0),

    /**
     * 变身加命
     */
    ADD_LIFE(1),

    /**
     * 敌方全炸
     */
    ENEMY_EXPLODE(2);

    public int type;

    AwardTypeEnum(int type) {
        this.type = type;
    }

    public static AwardTypeEnum getEnumByType(int type) {
        for (AwardTypeEnum value : AwardTypeEnum.values()) {
            if (type == value.type) {
                return value;
            }
        }
        return ADD_BLOOD_FIRE;
    }
}
