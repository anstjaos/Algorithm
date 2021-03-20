#ifndef _CRT_SECURE_NO_WARNINGS
#define _CRT_SECURE_NO_WARNINGS
#endif

#include <stdio.h>

typedef enum {
	MAKE = 1,
	CHANGE,
	REMOVE,
FIND
} COMMAND;

//-----------------------------------------------
// User API

#define MAX_SIZE 30000

struct Folder {
	Folder* child;
	Folder* left;
	Folder* right;
	Folder* parent;
	char name[24];
};

int strLen(const char* s)
{
	int len = 0;
	while (s[len] != 0) len++;
	return len;
}

int strCmp(const char* s1, const char* s2)
{
	int idx = 0;
	while (s1[idx] != 0 && s1[idx] == s2[idx]) idx++;
	return s1[idx] - s2[idx];
}

bool strSubCmp(const char* s1, const char* s2, int len)
{
	for (register int i = 0; i < len; i++) {
		if (s1[i] != s2[i]) return false;
	}
	return true;
}

void strCpy(const char* src, char* dest)
{
	int len = strLen(src);
	for (register int i = 0; i < len; i++) dest[i] = src[i];
	dest[len] = '\0';
}

Folder* root;
Folder* cur;
Folder folderPool[MAX_SIZE];
int poolCount;

void init()
{
	Folder temp = { 0, 0, 0, 0, '\0' };
	for (register int i = 0; i < poolCount; i++) folderPool[i] = temp;
	root = cur = &folderPool[0];
	poolCount = 1;
}

void make(char keyword[])
{
	Folder* ptr = cur->child;
	while (ptr != 0)
	{
		if (strCmp(ptr->name, keyword) == 0) return;
		ptr = ptr->right;
	}

	Folder* newFolder = &folderPool[poolCount++];
	strCpy(keyword, newFolder->name);
	newFolder->parent = cur;

	ptr = cur->child;
	if (ptr == 0) {
		cur->child = newFolder;
		return;
	}

	bool isTail = false;
	while (ptr != 0)
	{
		if (strCmp(keyword, ptr->name) < 0) break;
		if (ptr->right == 0) {
			isTail = true;
			break;
		}
		ptr = ptr->right;
	}

	if (isTail) {
		ptr->right = newFolder;
		newFolder->left = ptr;
	}
	else if (ptr == cur->child)	{
		newFolder->right = ptr;
		ptr->left = newFolder;
		cur->child = newFolder;
	}
	else {
		newFolder->left = ptr->left;
		newFolder->right = ptr;
		if (ptr->left != 0) ptr->left->right = newFolder;
		ptr->left = newFolder;
	}
}

void change(char keyword[])
{
	int len = strLen(keyword);
	if (keyword[0] == '/') {
		cur = root;
	}
	else if (strCmp(keyword, "..") == 0) {
		if(cur != root) cur = cur->parent;
	}
	else if (keyword[0] == '*') {
		cur = cur->child;
	}
	else if (keyword[len - 1] == '*') {
		Folder* ptr = cur->child;
		while (ptr != 0)
		{
			if (strSubCmp(ptr->name, keyword, len - 1)) {
				cur = ptr;
				break;
			}
			ptr = ptr->right;
		}
	}
	else {
		Folder* ptr = cur->child;
		while (ptr != 0)
		{
			if (strCmp(ptr->name, keyword) == 0) {
				cur = ptr;
				break;
			}
			ptr = ptr->right;
		}
	}
}

struct Queue {
	Folder* queue[MAX_SIZE];
	int front, rear;

	Queue() { front = rear = -1; }

	void push(Folder* folder)
	{
		rear = (rear + 1) % MAX_SIZE;
		queue[rear] = folder;
	}

	Folder* pop()
	{
		front = (front + 1) % MAX_SIZE;
		return queue[front];
	}

	bool isEmpty()
	{
		return front == rear;
	}
};

int remove(char keyword[])
{
	int len = strLen(keyword);
	Queue q;
	int ret = 0;

	if (keyword[0] == '*') {
		q.push(cur->child);
		cur->child = 0;
	}
	else if (keyword[len - 1] == '*') {
		Folder* ptr = cur->child;
		while (ptr != 0)
		{
			if (strSubCmp(ptr->name, keyword, len - 1)) {
				if (ptr == cur->child) {
					cur->child = ptr->right;
					if(ptr->right != 0) ptr->right->left = 0;
				}
				else {
					if (ptr->right != 0) ptr->right->left = ptr->left;
					ptr->left->right = ptr->right;
				}
				ret++;
				if(ptr->child != 0) q.push(ptr->child);
			}
			ptr = ptr->right;
		}
	}
	else {
		Folder* ptr = cur->child;
		while (ptr != 0)
		{
			if (strCmp(ptr->name, keyword) == 0) {
				if (ptr == cur->child) {
					cur->child = ptr->right;
					if (ptr->right != 0) ptr->right->left = 0;
				}
				else {
					if (ptr->right != 0) ptr->right->left = ptr->left;
					ptr->left->right = ptr->right;
				}
				ret++;
				if(ptr->child != 0) q.push(ptr->child);
				break;
			}
			ptr = ptr->right;
		}
	}

	while (!q.isEmpty())
	{
		Folder* p = q.pop();
		ret++;
		if (p->child != 0) q.push(p->child);
		if (p->right != 0) q.push(p->right);
	}
	return ret;
}

int find(char keyword[])
{
	Queue q;
	q.push(cur->child);
	int len = strLen(keyword);
	int ret = 0;

	while (!q.isEmpty())
	{
		Folder* ptr = q.pop();

		if(ptr->child != 0) q.push(ptr->child);
		if(ptr->right != 0) q.push(ptr->right);

		if (keyword[0] == '*') ret++;
		else if (keyword[len - 1] == '*') {
			if (strSubCmp(ptr->name, keyword, len-1)) ret++;
		}
		else {
			if (strCmp(ptr->name, keyword) == 0) ret++;
		}
	}
	return ret;
}

//----------------------------------------------


static int run(int Ans)
{
	int N = 0;
	scanf("%d", &N);

	init();

	int cmd, ret;
	char keyword[21];
	int score = 0, cnt = 0, answer;

	for (int i = 1; i <= N; i++)
	{
		scanf("%d %s", &cmd, keyword);

		switch (cmd)
		{
		case MAKE:
			make(keyword);
			break;

		case CHANGE:
			change(keyword);
			break;

		case REMOVE:
			scanf("%d", &answer);
			ret = remove(keyword);
			if (answer != ret) Ans = 0;
			break;

		case FIND:
			scanf("%d", &answer);
			ret = find(keyword);
			if (answer != ret) Ans = 0;
			break;

		default:
			break;
		}
	}
	return Ans;
}

int main()
{
	setbuf(stdout, NULL);
	//freopen("sample_input.txt", "r", stdin);

	int T, Ans = 100;
	scanf("%d", &T);

	for (int tc = 1; tc <= T; tc++) {
		printf("#%d %d\n", tc, run(Ans));
	}

	return 0;
}