#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, d[1010][1010];
vector<pair<int, int>> vt;

int go(int pos, int t) {
	if (pos == n || t > 1000) return 0;
	int &ret = d[pos][t];
	if (ret != -1) return ret;

	int ptime = vt[pos].first;
	int pcost = vt[pos].second;

	ret = max(ret, go(pos + 1, t));

	if (t <= ptime) ret = max(ret, go(pos + 1, t + 1) + pcost);

	return ret;
}

int main() {
	memset(d, -1, sizeof(d));
	scanf(" %d", &n);
	vt.resize(n);

	for (int i = 0; i < n; i++) scanf(" %d %d", &vt[i].first, &vt[i].second);

	sort(vt.begin(), vt.end());
	printf("%d\n", go(0, 1));
}