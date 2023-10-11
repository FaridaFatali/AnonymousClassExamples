package doer;

public class WeirdAnonymousDoerClassTest {
    private int i = 8;
    private static int k = 11;

    public static void main(String[] args) {
        WeirdAnonymousDoerClassTest test = new WeirdAnonymousDoerClassTest();
        System.out.println("callAnonymousDoerClass1() method calling:");
        test.callAnonymousDoerClass1();
        System.out.println("\ncallAnonymousDoerClass2() method calling:");
        test.callAnonymousDoerClass2();

        System.out.println("\naMethod() calling by new DoerClass:");
        test.aMethod(new DoerClass());
        System.out.println("\naMethod() calling by new DoerInterface throw override:");
        test.aMethod(new DoerInterface() {
            @Override
            public void doIt() {
                System.out.println("I have to do it.");
            }

            @Override
            public void doThat() {
                System.out.println("I have to do that.");
            }
        });
    }

    public void callAnonymousDoerClass1() {
        DoerInterface doerObject = new DoerInterface() {
            @Override
            public void doIt() {
                System.out.println("I'll always do it.");
                System.out.println("i: " + i + " k: " + k);
                aMethod(this);
            }

            @Override
            public void doThat() {
                System.out.println("\nI'll always do that.");
                doSomethingElse();
            }

            private void doSomethingElse() {
                System.out.println("I'll sometimes do that.");
            }
        };
        doerObject.doIt();
        doerObject.doThat();
//        doerObject.doSomethingElse(); // Can't all that!
    }

    public void callAnonymousDoerClass2() {
        int j = 3;
//        j++; //Not allowed to be used in anonymous class, because we can't change it

        (new DoerInterface() {
            private int t;
            private static final int z = 18;

            static {
                System.out.println("In static initializer block.");
            }

            {
                System.out.println("In instance initializer block.");
                t = 9;
                System.out.println("t: " + t);
            }

            @Override
            public void doIt() {
                System.out.println("I'm gonna always do it.");
                System.out.println("j: " + j);
                System.out.println("z: " + z);
//                j++; // Must be effectively final

                new DoerInterface() {
                    {
                        System.out.println("In inner instance initializer block.");
                    }

                    @Override
                    public void doIt() {
                        System.out.println("Inner doIt()");
                    }

                    @Override
                    public void doThat() {
                        System.out.println("Inner doThat()");
                    }
                }.doThat();
            }

            @Override
            public void doThat() {
                System.out.println("I'm gonna always do that.");
            }
        }).doIt();
    }

    public void aMethod(DoerInterface doerInterface) {
        System.out.println("In aMethod()");
//        doerInterface.doIt();
        doerInterface.doThat();
    }
}
