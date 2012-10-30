Some time ago, I was browsing on [rubyquiz](http://rubyquiz.com/) and found a really interesting exercise there. It’s name is [**Getting to 100**](http://rubyquiz.com/quiz119.html). The rules are quite simple:

1. You are given the sequence of numbers 123456789
2. Each number in the interval [1-9] has to be present in the sequence
3. Each number must appear once and only once
4. Numbers should be in increasing order
5. You are given three operators: two minuses and one plus that you have to insert between those numbers
6. The resulting equation should be give 100

The actual task is to:

* check whether an equation is correct syntactically and mathematically
* generate equations and tell whether they are correct or not

When solving the kata, you have to keep in mind the principle of single responsibility. This means that each and every method has to be doing one and only one thing. Of course this idea holds for classes too.