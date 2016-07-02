
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
	public Position<E> sibiling(Position<E> p){
		Position<E> parent = parent(p);
		if(parent == null) return null;
		if(p == left(parent))
			return right(parent);
		else {
			return left(parent);
		}
	}
}
