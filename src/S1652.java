
public class S1652 {

    public int[] decrypt(int[] code, int k) {
        return Decoder.decrypt(code ,k);
    }

    enum Decoder {
        NEXT {
            @Override
            public boolean isKey(int k) {
                return k > 0;
            }

            @Override
            public int[] decryptInternal(int[] code, int k) {
                int l = code.length;
                int[] res = new int[l];

                for (int i = 0; i < l; i++) {
                    int sum = 0;
                    int next = i;
                    for (int j = k; j > 0; j--) {
                        next = next + 1;
                        next = nextIdx(next, l);
                        sum += code[next];
                    }
                    res[i] = sum;
                }
                return res;
            }

            private int nextIdx(int next, int len) {
                return next < len ? next : 0;
            }
        },
        PREV {
            @Override
            public boolean isKey(int k) {
                return k < 0;
            }

            @Override
            public int[] decryptInternal(int[] code, int k) {
                int l = code.length;
                int[] res = new int[l];
                k = k*-1;

                for (int i = 0; i < l; i++) {
                    int sum = 0;
                    int next = i;

                    for (int j = k; j > 0; j--) {
                        next = next - 1;
                        next = nextIdx(next, l);
                        sum += code[next];
                    }
                    res[i] = sum;
                }
                return res;
            }

            private int nextIdx(int next, int len) {
                return next < 0 ? len - 1 : next;
            }
        },
        NIL {
            @Override
            public boolean isKey(int k) {
                return k == 0;
            }

            @Override
            public int[] decryptInternal(int[] code, int k) {
                return new int[code.length];
            }
        };

        public static int[] decrypt(int[] code, int k) {
            for (Decoder decoder : Decoder.values()) {
                if (decoder.isKey(k)) {
                    return decoder.decryptInternal(code, k);
                }
            }
            throw new RuntimeException("Invalid key");
        }

        public abstract boolean isKey(int k);

        public abstract int[] decryptInternal(int[] code, int k);
    }
}
