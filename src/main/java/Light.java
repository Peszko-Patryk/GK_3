public enum Light {
    AMBIENT(0.2f),
    KD(0.75f),
    KS(1.25f),
    N(500),
    IP(0.5f),
    MAX(1f),
    MIN(0.15f);

    float value;

    Light(float v) {
        value = v;
    }
}
