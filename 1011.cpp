#include <iostream>
using namespace std;

int main() {
	int n;
	unsigned int a, b, x;
	unsigned int k;
	scanf("%d", &n);
	for (int i = 0; i<n; i++) {
		scanf("%u%u", &a, &b);
		x = b - a;
		k = 0;
		for (unsigned int i = 1;; i++) {
			k += i;
			if (x <= k) {
				printf("%u\n",2*i-1);
					break;
			}
			k += i;
			if (x <= k) {
				printf("%u\n",2*i);
					break;
			}
		}
	}
}