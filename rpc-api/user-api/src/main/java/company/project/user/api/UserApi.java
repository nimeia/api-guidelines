package company.project.user.api;

/**
 * 用户api
 *
 * @author huang
 * @since 1.0.0
 */
public interface UserApi {

    /**
     * 用户详情
     *
     * @since 1.0.0
     * @param userId 用户id
     * @return
     */
    UserVo find(String userId);
}
