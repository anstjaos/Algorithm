#include<cstdio>
#include<queue>
#include<algorithm>
#include<vector>
using namespace std;

bool comp(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.first == b.first) return a.second > b.second;
	else return a.first > b.first;
}

int main() {
	int N;
	vector<pair<int, int> > work;
	priority_queue<int> pq;
	scanf("%d", &N);
	while (N--) {
		int s, e;
		scanf("%d %d", &s, &e);
		work.emplace_back(s, e);
	}
	sort(work.begin(), work.end(), comp);
	pq.push(-work.back().second);
	work.pop_back();
	while (work.size()) {
		auto& p = work.back();
		int top = -pq.top();
		if (top <= p.first) {
			pq.pop();
			pq.push(-p.second);
		}
		else {
			pq.push(-p.second);
		}
		work.pop_back();
	}
	printf("%d\n", (int)pq.size());
	return 0;
}