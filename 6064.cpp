#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int>> envel;

int N, M, x, y, tc, maxVal;

long long lcm(int a, int b)
{
	long long result = a * b;
	while (b != 0) {
		int r = a % b;
		a = b;
		b = r;
	}
	return (result / a);
}

int main()
{
	scanf("%d", &tc);
	while (tc--) {
		scanf("%d %d %d %d", &N, &M, &x, &y);
		bool isFind = false;
		long long temp = x;

		long long lcmNum;
		if(N < M) lcmNum = lcm(M, N);
		else lcmNum = lcm(N, M);
		int tempY = x;
		while (temp <= lcmNum) {
			tempY = tempY % M == 0 ? M : tempY % M;
			if (tempY == y) {
				isFind = true;
				break;
			}
			temp += N;
			tempY += N;
		}
		if (isFind) printf("%lld\n", temp);
		else printf("-1\n");
	}
	return 0;
}