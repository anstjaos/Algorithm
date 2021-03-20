#include <iostream>
#include <vector>
#include <queue>
using namespace std;


class Node {
public:
	int parent;
	int depth;
};

Node nodeList[50001];

vector<int> arr[50001];
queue<int> q;
int visit[50001];

int moveToDepth(int idx, int depth) {
	while (nodeList[idx].depth != depth) {
		idx = nodeList[idx].parent;
	}
	return idx;
}

int LCA(int a, int b) {
	if (a != b) {
		if (nodeList[a].depth < nodeList[b].depth) {
			//b를 a높이로
			b = moveToDepth(b, nodeList[a].depth);

		}
		else {
			//a를 b높이로
			a = moveToDepth(a, nodeList[b].depth);
		}
	}

	while (a != b) {
		a = moveToDepth(a, nodeList[a].depth - 1);
		b = moveToDepth(b, nodeList[b].depth - 1);
	}
	return a;
}

int main() {
	int N;
	scanf("%d", &N);
	for (int i = 0; i < N-1; i++) {
		int start, end;
		scanf("%d %d", &start, &end);
		arr[start].push_back(end);
		arr[end].push_back(start);
	}


	q.push(1);
	visit[1] = 1;
	while (q.empty() == false) {
		int t = q.front();
		q.pop();

		for (int i = 0; i < arr[t].size(); i++) {
			int n = arr[t][i];
			if (visit[n] == 0) {
				nodeList[n].parent = t;
				nodeList[n].depth = nodeList[t].depth + 1;
				q.push(n);
				visit[n] = 1;
			}
		}
	}

	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		printf("%d\n", LCA(a, b));
	}
	return 0;
}