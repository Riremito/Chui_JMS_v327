package constants;

import server.ServerProperties;

public class JobConstants {

    public static final boolean enableJobs = true;
    // UI.wz/Login.img/RaceSelect_new/order
    public static final int jobOrder = 0/*194*/;

    public enum LoginJob {

        末日反抗軍(0),
        冒險家(1),
        皇家騎士團(2),
        狂狼勇士(3),
        龍魔導士(4),
        精靈遊俠(5),
        惡魔(6),
        幻影俠盜(7),
        影武者(8),
//        米哈逸(9),
        夜光(9),
        凱撒(10),
        天使破壞者(11),
        重砲指揮官(12),
        傑諾(13),
        神之子(16),
//        隱月(16),
//        皮卡啾(17),
//        凱內西斯(18),
//        蒼龍俠客(19),
        劍豪(14),
        陰陽師(15),
        幻獸師(17),;
        private final int jobType;
        private final boolean enableCreate = true;

        private LoginJob(int jobType) {
            this.jobType = jobType;
        }

        public int getJobType() {
            return jobType;
        }

        public boolean enableCreate() {
            return Boolean.valueOf(ServerProperties.getProperty("JobEnableCreate" + jobType, String.valueOf(enableCreate)));
        }

        public void setEnableCreate(boolean info) {
            if (info == enableCreate) {
                ServerProperties.removeProperty("JobEnableCreate" + jobType);
                return;
            }
            ServerProperties.setProperty("JobEnableCreate" + jobType, String.valueOf(info));
        }
    }
}
