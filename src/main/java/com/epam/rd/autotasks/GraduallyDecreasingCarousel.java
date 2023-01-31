package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel {
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }
    @Override
    public CarouselRun run() {
        if (!isRun) {
            isRun = true;
            return new GraduallyRun();
        }
        return null;
    }
}
class GraduallyRun extends CarouselRun {
    int decrement = 1;

    @Override
    public int next() {
        int beforeDecreasing;
        if (isFinished())
            return -1;
        else {
            beforeDecreasing = array[position];
            array[position] -= decrement;
            do {
                position++;
                if (position == array.length) {
                    decrement++;
                    position = 0;
                }
            } while ((array[position] <= 0) && !isFinished());
        }
        return beforeDecreasing;
    }
}

/*class GraduallyDecreasingCarouselRun extends CarouselRun {

    public int decrementCounter = 1;

    @Override
    public int next() {
        int currentValue;
        if (isFinished()) {
            return -1;
        } else {
            currentValue = array[position];
            int decrementedValue = currentValue - decrementCounter;
            if (decrementedValue <= 0) {
                array[position] = 0;
                decrementCounter = 1;
            } else {
                array[position] = decrementedValue;
                decrementCounter++;
            }
            position++;
            if (position == array.length) {
                position = 0;
            }
            while (array[position % array.length] <= 0 && !isFinished()) {
                position++;
                if (position == array.length) {
                    position = 0;
                }
            }
        }
        return currentValue;
    }
}

  /*  @Override
    public CarouselRun run() {
        if (!isRun) {
            isRun = true;
            return new GraduallyDecreasingCarouselRun();
        }
        return null;
    }
}
    class GraduallyDecreasingCarouselRun extends CarouselRun {

        public int decrementCounter = 1;

        @Override
        public int next() {
            int currentValue;
            if (isFinished()) {
                return -1;
            } else {
                currentValue = array[position];
                array[position] = array[position] - decrementCounter;
                decrementCounter++;
                do {
                    position++;
                    if (position == array.length) {
                        position = 0;
                    }
                }
                while (array[position %= array.length] <= 0 && !isFinished());

            }
            return currentValue;
        }
    }

           /* int decrementedValue = currentValue - decrementCounter;
            if (decrementedValue <= 0) {
                decrementCounter = 1;
                array[position++] = 0;
            } else {
                decrementCounter++;
                array[position++] = decrementedValue;
            }
            return decrementedValue;
        }
    }
*/
