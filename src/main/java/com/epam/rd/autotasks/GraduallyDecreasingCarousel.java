package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel {
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

   /* @Override
    public boolean addElement(int element) {
        if (element > 0 && index < capacity && !isRun) {
            carousel[index++] = element;
            return true;
        }
        return false;
    }*/

    @Override
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
