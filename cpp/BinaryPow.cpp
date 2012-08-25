#include <iostream>
using namespace std;

int pow(int a, int b, int MOD) {
     int res = 1;
     for (; b > 0; b >>= 1) {
         if (b & 1)
             res = (long long) res * a % MOD;
         a = (long long) a * a % MOD;
     }
     return res;
 }

int main() {
     const int MOD = 1000000007;
     int x = pow(2, 10, MOD);
     cout << x << endl;
 }
