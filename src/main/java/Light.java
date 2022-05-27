public enum Light {
    AMBIENT(0.05f),
    KD(0.5f),
    KS(0.5f),
    N(50),
    IP(0.8f),
    MAX(1f),
    MIN(0.15f);

    float value;

    Light(float v) {
        value = v;
    }
}
