/*
Easy Hash Function Show Result My Submissions

11% Accepted
In data structure Hash, hash function is used to convert a string(or any other type) into an integer smaller than hash size and bigger or equal to zero. The objective of designing a hash function is to "hash" the key as unreasonable as possible. A good hash function can avoid collision as less as possible. A widely used hash function algorithm is using a magic number 33, consider any string as a 33 based big integer like follow:

hashcode("abcd") = (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE 

                              = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE

                              = 3595978 % HASH_SIZE

here HASH_SIZE is the capacity of the hash table (you can assume a hash table is like an array with index 0 ~ HASH_SIZE-1).

Given a string as a key and the size of hash table, return the hash value of this key.f



Example
For key="abcd" and size=100, return 78

Clarification
For this problem, you are not necessary to design your own hash algorithm or consider any collision issue, you just need to implement the algorithm as described.
*/
class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        if (key == null) {
            return 0;
        }
        long result = 0;
        long j = key.length - 1;
        for (int i = 0; i <= key.length - 1; i++) {
            result += (long)(key[i]) * fastPowerHelper((long)33, j, (long) HASH_SIZE);
            result %= HASH_SIZE;
            j--;
        }
        return (int)(result);
    }
    
     private long fastPowerHelper(long a, long b, long n) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a % n;
        }
        long result = fastPowerHelper(a, b / 2, n) % n;
        if (b % 2 == 1) {
            return (((a % n * result) % n) * result) % n ;
        }
        return (result * result) % n;
    }
};
