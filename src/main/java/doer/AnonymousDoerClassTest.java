package doer;

public class AnonymousDoerClassTest {
    public static void main(String[] args) {
        AnonymousDoerClassTest test = new AnonymousDoerClassTest();
        System.out.println("callAnonymousDoerClass1() method:");
        test.callAnonymousDoerClass1();
        System.out.println("\ncallAnonymousDoerClass2() method:");
        test.callAnonymousDoerClass2();

        System.out.println("\nDoerClass throw aMethod():");
        test.aMethod(new DoerClass());

        System.out.println("\nDoerInterface throw aMethod() with override:");
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

    public static void callAnonymousDoerClass1() {
        DoerInterface doerObject = new DoerInterface() {
            @Override
            public void doIt() {
                System.out.println("I'll always do ot.");
            }

            @Override
            public void doThat() {
                System.out.println("I'll always do that.");
            }
        };
        doerObject.doIt();
        doerObject.doThat();
    }

    public static void callAnonymousDoerClass2() {
        (new DoerInterface() {
            {
                System.out.println("in DoerInterface() initializer.");
            }

            @Override
            public void doIt() {
                System.out.println("I'm gonna always do it.");
            }

            @Override
            public void doThat() {
                System.out.println("I'm gonna always do that.");
            }
        }).doIt();
    }

    public void aMethod(DoerInterface doerInterface) {
        System.out.println("In aMethod()");
        doerInterface.doIt();
        doerInterface.doThat();
    }
}
