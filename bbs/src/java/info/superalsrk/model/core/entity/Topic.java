package info.superalsrk.model.core.entity;

// Generated 2013-3-30 18:00:53 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * Topic generated by hbm2java
 */
@Entity
@Table(name = "topic", catalog = "bbs")
public class Topic implements java.io.Serializable {

	private String id;
	private Subforum subforum;
	private User user;
	private Date postTime;
	private Date lastreplyTime;
	private String topicContent;
	private Set<Reply> replies = new HashSet<Reply>(0);

	public Topic() {
	}

	public Topic(String id) {
		this.id = id;
	}

	public Topic(String id, Subforum subforum, User user, Date postTime,
			Date lastreplyTime, String topicContent, Set<Reply> replies) {
		this.id = id;
		this.subforum = subforum;
		this.user = user;
		this.postTime = postTime;
		this.lastreplyTime = lastreplyTime;
		this.topicContent = topicContent;
		this.replies = replies;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subforum_id")
	public Subforum getSubforum() {
		return this.subforum;
	}

	public void setSubforum(Subforum subforum) {
		this.subforum = subforum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "originalPoster")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "postTime", length = 19)
	public Date getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastreplyTime", length = 19)
	public Date getLastreplyTime() {
		return this.lastreplyTime;
	}

	public void setLastreplyTime(Date lastreplyTime) {
		this.lastreplyTime = lastreplyTime;
	}

	@Column(name = "topicContent", length = 65535)
	public String getTopicContent() {
		return this.topicContent;
	}

	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
	public Set<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

}
